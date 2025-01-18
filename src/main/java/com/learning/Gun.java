package com.learning;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class Gun implements Fire{
    @Override
    public void fire() {
        System.out.println("Fired via gun");
    }

}
