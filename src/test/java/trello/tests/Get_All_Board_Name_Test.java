package trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import trello.common.Base;
import trello.functions.TrelloMembers;

import java.util.List;

public class Get_All_Board_Name_Test extends Base {

    //BaseTest needs tobe extended so that common spec value can be populated so that in the hierachy
    // we can call @BeforeSuite and
    //commonspec to get the value

    @Test
    public void testMyBoards(){

        List<String> boardName = TrelloMembers.getBoardsNameForThisMember();
        System.err.println("List of Board Names :"+boardName);
        //test case
//        Assert.assertEquals(boardName.size(),3);


    }
}
