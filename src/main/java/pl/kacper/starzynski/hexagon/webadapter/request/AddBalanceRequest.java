package pl.kacper.starzynski.hexagon.webadapter.request;

import lombok.Value;

@Value
public class AddBalanceRequest {
    String newBalance;
    String currency;
}
