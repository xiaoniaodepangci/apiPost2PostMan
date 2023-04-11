package postman.apipost.convert.postman2apipost.adapter;

import postman.apipost.convert.postman2apipost.apipost.ApiPostAuth;
import postman.apipost.convert.postman2apipost.postman.PostManAuth;

public class AuthAdapter extends AbstractBaseAdapter<PostManAuth, ApiPostAuth>{

    @Override
    public ApiPostAuth sourceToTarget(PostManAuth source) {
        return null;
    }

    @Override
    public PostManAuth targetToSource(ApiPostAuth target) {
        return null;
    }
}
