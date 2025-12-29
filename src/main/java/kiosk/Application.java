package kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final ArrayList<ShoppingCart> carts = new ArrayList<>();

    //숫자만 입력받을 수 있도록 exception 및 입력받기
    public static int inputValue(String message) {
        System.out.print(message);
        try {
            return Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // 장바구니 담기
    public static void addToCart(String name, int price) {
        boolean exists = false;
        for (ShoppingCart item : carts) {
            if (item.getItem().equals(name)) {
                item.setQuantity(item.getQuantity() + 1);
                exists = true;
                break;
            }
        }
        if (!exists) {
            carts.add(new ShoppingCart(name, 1, price));
        }
        System.out.println(name + " 장바구니에 담겼습니다.");
    }

    // 장바구니 내용 출력 (장바구니 화면)
    public static void printCart() {
        System.out.println("===== 장바구니 =====\n");
        if (carts.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
        } else {
            for (ShoppingCart item : carts) {
                // ShoppingCart의 getter 사용
                System.out.println("- " + item.getItem() + " " + item.getQuantity() + "개");
            }
        }
        System.out.println();
    }

    // 장바구니 내용 출력 (번호 포함)
    public static void printCartItems() {
        for (int i = 0; i < carts.size(); i++) {
            ShoppingCart item = carts.get(i);
            System.out.println((i + 1) + ". " + item.getItem() + " " + item.getQuantity() + "개");
        }
        System.out.println();
    }

    // 총액 계산
    public static int calculateTotal() {
        int total = 0;
        for (ShoppingCart item : carts) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public static void burgerKingKiosk() {
        int currentMenu = 0; //현재 메뉴 번호
        boolean isRunning = true;

        while (isRunning) {
            int select = 0;

            switch (currentMenu) {
                //home
                case 0:
                    select = inputValue("""
                            =====홈=====
                           \s
                            1. 햄버거
                            2. 사이드
                            3. 음료
                            4. 장바구니
                            5. 종료
                           \s
                            메뉴선택:\s""");

                    if (select == 1) currentMenu = 1;
                    else if (select == 2) currentMenu = 2;
                    else if (select == 3) currentMenu = 3;
                    else if (select == 4) currentMenu = 4;
                    else if (select == 5) {
                        System.out.println("프로그램을 종료합니다.");
                        isRunning = false;
                    }
                    break;

                //hamburger
                case 1:
                    System.out.println("=====햄버거 메뉴=====\n");
                    Menu.Burger[] burgers = Menu.Burger.values();
                    for (int i = 0; i < burgers.length; i++) {
                        System.out.println((i + 1) + ". " + burgers[i].getName() + " (" + burgers[i].getPrice() + "원)");
                    }
                    System.out.println();

                    select = inputValue("메뉴선택 (0을 선택 시 홈으로): ");
                    if (select == 0) currentMenu = 0;
                    else if (select > 0 && select <= burgers.length) {
                        addToCart(burgers[select - 1].getName(), burgers[select - 1].getPrice());
                    }
                    break;

                //side
                case 2:
                    System.out.println("=====사이드 메뉴=====\n");
                    Menu.SideDish[] sides = Menu.SideDish.values();
                    for (int i = 0; i < sides.length; i++) {
                        System.out.println((i + 1) + ". " + sides[i].getName() + " (" + sides[i].getPrice() + "원)");
                    }
                    System.out.println();

                    select = inputValue("메뉴선택 (0을 선택 시 홈으로): ");
                    if (select == 0) currentMenu = 0;
                    else if (select > 0 && select <= sides.length) {
                        addToCart(sides[select - 1].getName(), sides[select - 1].getPrice());
                    }
                    break;

                //drink
                case 3:
                    System.out.println("=====음료 메뉴=====\n");
                    Menu.Drink[] drinks = Menu.Drink.values();
                    for (int i = 0; i < drinks.length; i++) {
                        System.out.println((i + 1) + ". " + drinks[i].getName() + " (" + drinks[i].getPrice() + "원)");
                    }
                    System.out.println();

                    select = inputValue("메뉴선택 (0을 선택 시 홈으로): ");
                    if (select == 0) currentMenu = 0;
                    else if (select > 0 && select <= drinks.length) {
                        addToCart(drinks[select - 1].getName(), drinks[select - 1].getPrice());
                    }
                    break;

                //shopping carts
                case 4:
                    printCart();
                    System.out.println("====================");
                    System.out.println("1. 주문하기");
                    System.out.println("2. 수량 조절하기");
                    System.out.println("3. 삭제하기");
                    System.out.println("\n총 가격: " + calculateTotal() + "원\n");

                    select = inputValue("메뉴선택 (0을 선택 시 홈으로): ");

                    if (select == 0) currentMenu = 0;
                    else if (select == 1) { // 주문하기
                        if (carts.isEmpty()) {
                            System.out.println("장바구니가 비어있습니다.");
                        } else {
                            System.out.println("주문이 완료되었습니다! (총 " + calculateTotal() + "원)");
                            carts.clear();
                        }
                        currentMenu = 0;
                    } else if (select == 2) { // 수량 조절
                        currentMenu = 5;
                    } else if (select == 3) { // 삭제
                        currentMenu = 6;
                    }
                    break;

                //수량 조절
                case 5:
                    System.out.println("===== 수량 조절하기 =====\n");
                    System.out.println("현재 장바구니\n");
                    printCartItems();

                    if(carts.isEmpty()) {
                        currentMenu = 4;
                        break;
                    }

                    int itemNumber = inputValue("수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
                    if (itemNumber == 0) {
                        currentMenu = 0;
                    } else if (itemNumber > 0 && itemNumber <= carts.size()) {
                        int newQuantity = inputValue("변경할 수량을 입력하세요: ");
                        if (newQuantity > 0) {
                            carts.get(itemNumber - 1).setQuantity(newQuantity);
                            System.out.println("수량이 변경되었습니다.");
                            currentMenu = 4;
                        } else {
                            System.out.println("수량은 1 이상이어야 합니다.");
                        }
                    }
                    break;

                //delete
                case 6:
                    System.out.println("===== 삭제하기 =====\n");
                    System.out.println("현재 장바구니\n");
                    printCartItems();

                    if(carts.isEmpty()) {
                        currentMenu = 4;
                        break;
                    }

                    int delNumber = inputValue("삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
                    if (delNumber == 0) {
                        currentMenu = 0;
                    } else if (delNumber > 0 && delNumber <= carts.size()) {
                        int check = inputValue("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
                        if (check == 1) {
                            carts.remove(delNumber - 1);
                            System.out.println("삭제되었습니다.");
                            currentMenu = 4;
                        } else {
                            currentMenu = 0;
                        }
                    }
                    break;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        burgerKingKiosk();
    }
}