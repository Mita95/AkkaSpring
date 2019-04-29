import org.springframework.beans.factory.annotation.Autowired;

public class Reader {

    @Autowired
    IReader iReader;

    public void read(){
        iReader.listen();
    }
}
