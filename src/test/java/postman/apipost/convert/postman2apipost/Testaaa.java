package postman.apipost.convert.postman2apipost;

import postman.apipost.convert.postman2apipost.listcreate.BagList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Testaaa {
    public static void main(String[] args) {

        List<String> aa = new ArrayList<>();

        aa.add("aa");
        aa.add("aa");
        aa.add("aa");
        aa.add("aa");

        aa.forEach(i -> i = i + "bb");

        List<Object> collect = aa.stream().map(s -> s + "bb").collect(Collectors.toList());

        System.out.println(collect);

        final BagList bagList = new BagList();
        bagList.setName("asd");
    }
}
