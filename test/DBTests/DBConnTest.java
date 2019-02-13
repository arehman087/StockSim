package DBTests;

import org.junit.jupiter.api.Test;
import Server.Databases.*;

import static org.junit.jupiter.api.Assertions.*;

class DBConnTest {

    @Test
    void testInsertUser(){
        DBConn testDB = new DBConn();

        int rows = testDB.insertUser("Abdul", "Rehman", "arehma7", "password", 0.0d);

        assertEquals(1, rows);

        rows = testDB.insertUser("Abdul", "Rehman", "arehma7", "password", 0.0d);

        assertEquals(-1, rows);
    }

    @Test
    void testInsertWatchlist(){
        DBConn testDB = new DBConn();

        int rows = testDB.insertWatchList("MSFT", 63.4d, 1,  1);

        assertEquals(1, rows);

    }

    @Test
    void  testInsertTransaction(){
        DBConn testDB = new DBConn();

        int rows = testDB.insertTransaction("MSFT", 63.4, -1,4, 1);

        assertEquals(1, rows);
    }

    @Test
    void testUserRet(){
        DBConn db = new DBConn();

        UserData u = db.getUser("arehma7", "password");

        assertNotNull(u);

        u = db.getUser("jguo", "pass2");

        assertNull(u);
    }
}
