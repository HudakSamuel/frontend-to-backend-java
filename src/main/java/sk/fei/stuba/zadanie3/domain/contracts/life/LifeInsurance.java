package sk.fei.stuba.zadanie3.domain.contracts.life;

import sk.fei.stuba.zadanie3.domain.contracts.Contract;
import sk.fei.stuba.zadanie3.domain.user.User;

import javax.validation.constraints.NotNull;

public abstract class LifeInsurance extends Contract {

    @NotNull
    protected User assured;

    public void setAssured(User assured) {
        if(assured == null){
            throw new IllegalArgumentException();
        }
        this.assured = assured;
    }

    public User getAssured() {
        return assured;
    }
}
