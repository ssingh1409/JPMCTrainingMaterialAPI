package mockito;

import org.mockito.Mockito;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import trello.functions.Boards;
import trello.functions.Cards;

public class TrelloCreateNewCard {

    Boards board;

    @BeforeTest
    public void setUpMocks(){

        //So we have mocked the value which is not present by hardcoding the values so that when you are testing your condition it will
        //not be hampered
        Boards board =Mockito.mock(Boards.class);
        Mockito.when(board.getListIDByListName("To Do","62y2yw7t727tgghg72788")).thenReturn("611e09f62b79322bbe3d9d1b");
    }

    @Test
    public void testCreationOfNewCard(){
        //1. You need a BOARD id - team b
        //2. You need a LIST Id - Team C

//        For mocking condition is you should have the class ready which you wanted to mock

        //3. Only then we create a Card - Team A
        //Now given a condition tat team B and Team C is not ready but you need
        //to test and create a crad using list id so we use mocking
        String listid = board.getListIDByListName("To Do","1427fwf78799897");
        Cards.addNewCardToListUsingListId(listid,"Learning Mockito");

    }
}
