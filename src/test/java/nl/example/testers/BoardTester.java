package nl.example.testers;

import io.cucumber.core.exception.CucumberException;
import nl.example.common.api.QueryParameter;
import nl.example.data.dto.Board;
import nl.example.data.response.BoardResponse;
import nl.example.testers.base.BaseTester;
import org.junit.platform.commons.util.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BoardTester extends BaseTester {

    private static final String POST_BOARD_ENDPOINT = "/1/boards/";
    private static final String DELETE_BOARD_ENDPOINT = "/1/boards/{id}";
    private static final String GET_BOARDS_ENDPOINT = "/1/members/me/boards?fields=name,url";

    private String boardId;

    public void createBoard(Board board) {
        QueryParameter boardName = QueryParameter.builder()
                .key("name").value(board.getName())
                .build();

        boardId = getRest().addQueryParameter(boardName).postRequest(POST_BOARD_ENDPOINT)
                .then().extract().path("id");
    }

    public void deleteBoard() {
        if (StringUtils.isNotBlank(boardId)) {
            getRest().deleteRequest(DELETE_BOARD_ENDPOINT, boardId);
        }
    }

    public String getBoardUri(Board board) throws MalformedURLException {
        List<BoardResponse> boards = getRest().getRequest(GET_BOARDS_ENDPOINT)
                .then()
                .extract()
                .body().jsonPath().getList(".", BoardResponse.class);

        BoardResponse boardResponse = boards.stream()
                .filter(item -> item.getName().equals(board.getName()))
                .findFirst()
                .orElseThrow(() -> new CucumberException("Created board not found in list"));

        return new URL(boardResponse.getUrl()).getPath();
    }

}
