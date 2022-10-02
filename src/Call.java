import java.util.Date;
import java.util.UUID;

public class Call {
    private final String idCall;
    private final int callNumber;
    private final Date date;

    public Call(int callNumber) {
        this.idCall = UUID.randomUUID().toString(); //генерация уникального id звонка
        this.callNumber = callNumber;
        this.date = new Date();
    }

    public int getCallNumber() {
        return callNumber;
    }

    @Override
    public String toString() {
        return "Вызов{" + " [" + date + //, date=
                "], от абонента=" + callNumber +
                ", id звонка='" + idCall + '\'' +
                '}';
    }
}