package trello.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import trello.common.Base;
import trello.common.ExcelReader;
import trello.functions.Boards;
import trello.functions.Cards;
import trello.functions.TrelloMembers;

import java.io.IOException;

import static trello.functions.Cards.*;

public class Create_Cards_Test extends Base {

    @Test
    public void testCreateCardInNewBoard(){

        //Work Flow Test
        //1.Create new board
        // 2. Get the id of the new board created
        String newboardId = Boards.createBoardAndReturnId("MyCreationTest");
//        System.out.println("New Board Id is :"+newboardId);

        //3. For this new board , get the list by name "To Do"
        String todoListId= Boards.getListIDByListName("Done","611e09f62b79322bbe3d9d1b");
        System.out.println("List Id is "+todoListId);
        //4 . Add a new card to the above list

       int status = Cards.addNewCardToListUsingListId(todoListId,"Learning Framework Creation ");
        System.out.println(status);
        Assert.assertEquals(status,200);
    }

    @Test(dataProvider = "getTestDataFromExcel")
    public void testCreateCardInExistingBoardDataDriven(String BoardName, String ListName,String CardTitle){


        //1. Get board id of an existing board by name

        String boardid = TrelloMembers.getBoardIDByName(BoardName);
        System.out.println("Existing Board Id is :"+boardid);

        //3. For this new board , get the list by name "To Do"
        String todoListId= Boards.getListIDByListName("Done",boardid);
        System.out.println("List Id is "+todoListId);
//        //4 . Add a new card to the above list

        int status = Cards.addNewCardToListUsingListId(todoListId,CardTitle);
        System.out.println(status);
        Assert.assertEquals(status,200);
    }

    @DataProvider
    public Object[][] getTestDataFromExcel() throws IOException {
       return ExcelReader.readExcelData("src/test/java/trello/resources/testdata.xlsx");
    }
 }
