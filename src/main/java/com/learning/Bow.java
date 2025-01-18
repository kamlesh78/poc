package com.learning;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class Bow implements Fire{
    @Override
    public void fire() {
        System.out.println("Fired via Bow");
    }
}
