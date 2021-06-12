import com.codeborne.selenide.Condition;
import com.codeborne.selenide.commands.ShouldBe;
import org.graalvm.compiler.code.DataSection;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.*;

public class CardDeliveryTest {
    @Test
    void shouldOrderOfDeliveryCard() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Саратов");
        String dayVisit = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=date] input").sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        $("[data-test-id=date] input").setValue(dayVisit);
        $("[data-test-id=name] input").setValue("Герцен Александр");
        $("[data-test-id=phone] input").setValue("+79008889966");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $(withText("Успешно!")).shouldBe(Condition.visible, ofSeconds(15));
           }
}
