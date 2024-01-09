import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){

        System.out.println("Macere Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir kullanıcı adı giriniz: ");
        String playerName=input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName()+ " bu karanlık ve sisli adaya  Hoşgeldiniz ! Burada yaşananların hepsi gerçek");
        System.out.println("Lütfen bir karakter seçiniz ! ");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        player.selectChar();

        Location location = null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("####### Bölgeler #######");
            System.out.println();
            System.out.println("1 - Güvenli Ev --> Burası sizin için güvenli bir ev, düşman yoktur !");
            System.out.println("2 - Eşya Dükkanı --> Silah veya Zırh satın alabilirsiniz !");
            System.out.println("3 - Mağara -->  Ödül <yemek>, dikkatli ol zombi çıkabilir !");
            System.out.println("4 - Orman --> Ödül <odun>, dikkatli ol vampir çıkabilir !");
            System.out.println("5 - Nehir --> Ödül <su>, dikkatli ol ayı çıkabilir !");
            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır. ");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz ! ");
            }
            if (location == null){
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin. ");
                break;
            }
           if(!location.onLocation()){
               System.out.println("GAME OVER");
               break;
           }
        }


    }
}
