package pl.kacper.starzynski.hexagon.domain;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor(staticName = "of")
public class AccountId {
    private final UUID id;
}
