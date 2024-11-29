package com.ghada.commercial.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;
@Data
@EqualsAndHashCode(callSuper=true)

public class BuisnessException extends RuntimeException {

    private final String msg;

}
