package cn.yxswallow.protocols.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * Data Transfer object, including Command, Query and Response,
 * <p>
 * Command and Query is CQRS concept.
 *
 * @author yaoxing
 */
public abstract class DTO implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
}
