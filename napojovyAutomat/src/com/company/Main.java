package com.company;

public class Main {

    public static void main(String[] args) {
        BeverageMaker beverageMaker = new BeverageMaker();
        beverageMaker.addBeverage(new Caj());
        beverageMaker.addBeverage(new Kava());
        beverageMaker.addBeverage(new Polevka());
        beverageMaker.setCupSize(CupSize.BIG);
        System.out.println(beverageMaker.prepare(1));
// -> 'Připravuji velký šálek - Káva - Káva se vyrábí z kávového prášku a vody.'
        System.out.println(beverageMaker.prepare(0));
// -> 'Připravuji velký šálek - Čaj - Čaj se skládá ze sirupu a vody.'
        beverageMaker.setCupSize(CupSize.SMALL);
        System.out.println(beverageMaker.prepare(0));
// -> Připravuji malý šálek - Čaj - Čaj se skládá ze sirupu a vody.
        System.out.println(beverageMaker.prepare(3));
// -> 'Tento nápoj není k dispozici!
    }
}
