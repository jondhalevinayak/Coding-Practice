package com.local.coding_practice.SystemDesign1.SnakeAndLadder1;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {

    int position;
    String userName;

    public Player(String userName) {
        this.userName = userName;
        this.position = 0;
    }


}
