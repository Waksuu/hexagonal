package pl.kacper.starzynski.hexagon.webadapter.request;

import lombok.Value;

@Value
public class WithdrawBalanceRequest {
    String withdrawAmount;
    String currency;
}
