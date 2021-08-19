package trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import trello.common.Base;
import trello.functions.CreateBoard;
import trello.functions.TrelloMembers;

import java.util.List;

public class Create_Board_Test extends Base {

    @Test
    public void testCreateBoard(){

      int statusCode = CreateBoard.createNewBoard("Board_JPMC");
        Assert.assertEquals(statusCode,200);

    }
}
