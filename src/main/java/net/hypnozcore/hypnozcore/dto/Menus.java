package net.hypnozcore.hypnozcore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Menus {
    private long id;
    private String title;
    private String icon;
    private String routerLink;
    private String target;
    private long parentId;
    private boolean active;
    private boolean hasSubMenu;
}
