package com.oceanier.vo.user;

import java.io.Serializable;

public class UserVo implements Serializable {
    private CustomUser customUser;

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }
}
