package trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import trello.common.Base;
import trello.functions.Boards;
import trello.functions.TrelloMembers;

public class Delete_Board_Test extends Base {

    @Test
    public void testDeleteBoard(){

        String  boardid = TrelloMembers.getFirstIdOfBoard();
        boolean val=Boards.deleteBoard(boardid);
        Assert.assertEquals(val,true);

    }
}
