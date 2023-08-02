package com.mjc.school;

import com.mjc.school.service.Validator;
import com.mjc.school.service.exceptions.AuthorIDException;
import com.mjc.school.service.exceptions.NewsIDException;
import com.mjc.school.service.exceptions.TitleOrContentLengthException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.mjc.school.service.ErrorMessages.*;

public class ValidatorTest {

    @Test
    public void titleValidateTest() {
        TitleOrContentLengthException thrown = Assertions.assertThrows(TitleOrContentLengthException.class, () -> {
            Validator.titleAndContentValidate("sasa", "mdkalsnfokan");
        });

        Assertions.assertEquals(String.format(ERROR_CODE_2, "title", 30), thrown.getMessage());
    }

    @Test
    public void contentValidateTest() {
        TitleOrContentLengthException thrown = Assertions.assertThrows(TitleOrContentLengthException.class, () -> {
            Validator.titleAndContentValidate("sasaasasd", "mdkn");
        });

        Assertions.assertEquals(String.format(ERROR_CODE_2, "content", 255), thrown.getMessage());
    }

    @Test
    public void newsIdValidatorTest() {
        NewsIDException thrown = Assertions.assertThrows(NewsIDException.class, () -> {
            Validator.newsIdValidator("as");
        });

        Assertions.assertEquals(ERROR_CODE_3, thrown.getMessage());

        NewsIDException thrown2 = Assertions.assertThrows(NewsIDException.class, () -> {
            Validator.newsIdValidator("-1");
        });

        Assertions.assertEquals(ERROR_CODE_1, thrown2.getMessage());
    }

    @Test
    public void authorIdValidatorTest() {
        AuthorIDException thrown = Assertions.assertThrows(AuthorIDException.class, () -> {
            Validator.authorIdValidator("as");
        });

        Assertions.assertEquals(ERROR_CODE_5, thrown.getMessage());

        AuthorIDException thrown2 = Assertions.assertThrows(AuthorIDException.class, () -> {
            Validator.authorIdValidator("-1");
        });

        Assertions.assertEquals(ERROR_CODE_4, thrown2.getMessage());
    }
}
