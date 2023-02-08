package ch.heig.amt.exa.DEBLESER.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuoteNotFoundException extends RuntimeException {
    public QuoteNotFoundException(Integer id) {
        super("Quote " + id + " non trouvée");
    }
}
