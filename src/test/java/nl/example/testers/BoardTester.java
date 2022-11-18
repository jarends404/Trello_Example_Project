package nl.example.testers;

import io.cucumber.core.exception.CucumberException;
import io.restassured.response.Response;
import nl.example.common.api.QueryParameter;
import nl.example.data.dto.Board;
import nl.example.data.response.BoardResponse;
import nl.example.data.response.ListResponse;
import nl.example.testers.base.BaseTester;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BoardTester extends BaseTester {

    private static final String POST_BOARD_ENDPOINT = "/1/boards/";
    private static final String UPDATE_BOARD_ENDPOINT = "/1/boards/{id}";
    private static final String GET_BOARDS_ENDPOINT = "/1/members/me/boards";
    private static final String GET_LISTS_ON_BOARD_ENDPOINT = "/1/boards/{id}/lists";

    private String boardId;

    public void createBoard(Board board) {
        QueryParameter name = new QueryParameter("name", board.getName());
        Response response = getRest().addQueryParameter(name).postRequest(POST_BOARD_ENDPOINT);

        boardId = response.then().extract().path("id");
        Assertions.assertEquals(board.getName(), response.then().extract().path("name"));
    }

    public void closeBoard() {
        if (StringUtils.isNotBlank(boardId)) {
            QueryParameter closed = new QueryParameter("closed", "true");
            getRest().addQueryParameter(closed).putRequest(UPDATE_BOARD_ENDPOINT, boardId);
        }
    }

    public void deleteBoard() {
        if (StringUtils.isNotBlank(boardId)) {
            getRest().deleteRequest(UPDATE_BOARD_ENDPOINT, boardId);
        }
    }

    public String getBoardUri(Board board) throws MalformedURLException {
        List<BoardResponse> boards = getRest().getRequest(GET_BOARDS_ENDPOINT)
                .then()
                .extract()
                .body().jsonPath().getList(".", BoardResponse.class);

        BoardResponse createdBoard = boards.stream()
                .filter(item -> item.getName().equals(board.getName()))
                .findFirst()
                .orElseThrow(() -> new CucumberException("Created board not found in list"));

        return new URL(createdBoard.getUrl()).getPath();
    }

    public String getListId(String list) {
        List<ListResponse> lists = getRest().getRequest(GET_LISTS_ON_BOARD_ENDPOINT, boardId)
                .then()
                .extract()
                .body().jsonPath().getList(".", ListResponse.class);

        ListResponse wantedList = lists.stream()
                .filter(item -> item.getName().equals(list))
                .findFirst()
                .orElseThrow(() -> new CucumberException("Created board not found in list"));

        return wantedList.getId();
    }

}
