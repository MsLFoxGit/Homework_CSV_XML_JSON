import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MslTest {
    @Test
    @DisplayName("mslTset: invalid fileName ")
    public void writeStringTest(){
        String[] notValidFileName = {
                "data.jsom",
                "data.jsonA",
                "d ata.json",
                ".json"
        };
        String json = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"Smith\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"age\": 25\n" +
                "  },\n" +
                "]";
        for (String itemNotValidFileName: notValidFileName)
              {
                  Assertions.assertThrows(IllegalStateException.class,
                          () -> Task1.writeString( json, itemNotValidFileName));
        }
    }
}
