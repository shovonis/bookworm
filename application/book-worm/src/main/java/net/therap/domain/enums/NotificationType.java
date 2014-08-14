package net.therap.domain.enums;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/4/14 4:26 PM
 */

public enum NotificationType {
    EXCHANGE,
    PURCHASE,
    APPROVAL,
    IGNORE;
    public static final int CLOSE = 4;

    public static final NotificationType values[] = values();
}
