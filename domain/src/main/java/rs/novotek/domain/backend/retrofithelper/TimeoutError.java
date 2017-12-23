/*
    Dandre' Allison
    imminent
 */
package rs.novotek.domain.backend.retrofithelper;

import java.io.IOException;

public class TimeoutError extends IOException {
    private static final long serialVersionUID = -6469766654369165864L;

    public TimeoutError() {
        super();
    }

    public TimeoutError(Throwable cause) {
        super(cause);
    }
}
