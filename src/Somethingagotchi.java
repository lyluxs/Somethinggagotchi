import java.util.Random;
import java.util.Scanner;

public class Somethingagotchi {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int cordura = 100;
        int miedo = 0;
        int energia = 100;
        int oscuridad = 50;
        int dia = 1;

        System.out.println("====================================");
        System.out.println("         SOMETHINGAGOTCHI");
        System.out.println("====================================");

        System.out.print("Escribe tu nombre: ");
        String nombre = sc.nextLine();

        // 👥 RUTAS
        boolean modoSunny = nombre.equalsIgnoreCase("Sunny");
        boolean modoMari = nombre.equalsIgnoreCase("Mari");
        boolean modoBasil = nombre.equalsIgnoreCase("Basil");

        // 🧠 MEMORIA SIMPLE DEL JUEGO
        boolean vioSomething = false;
        boolean escuchoVoz = false;

        while (true) {

            // TIEMPO
            miedo += random.nextInt(10);
            energia -= random.nextInt(8);
            oscuridad += random.nextInt(6);

            if (modoSunny) miedo += 2;
            if (modoBasil) miedo += 1;
            if (modoMari) cordura += 1;

            if (miedo > 100) miedo = 100;
            if (energia > 100) energia = 100;
            if (oscuridad > 100) oscuridad = 100;

            if (miedo < 0) miedo = 0;
            if (energia < 0) energia = 0;
            if (oscuridad < 0) oscuridad = 0;

            if (miedo > 70) cordura -= 10;
            if (cordura < 0) cordura = 0;

            // 👁️ SOMETHING (CAMBIA POR RUTA + MEMORIA)
            String something;

            int eyeOffset = random.nextInt(3);
            String eyeLine = (eyeOffset == 0)
                    ? "      .'   O   '."
                    : (eyeOffset == 1)
                      ? "      .' O       '."
                      : "      .'       O  '.";

            if (miedo > 70) {

                something =
                        "        .-''''-.\n" +
                                eyeLine + "\n" +
                                "     /            \\\n" +
                                "    |    __      |\n" +
                                "    |   / __ \\     |\n" +
                                "    |   \\__/     |\n" +
                                "     \\            /\n" +
                                "      '.        .'\n" +
                                "        '-.__.-'\n" +
                                "          ||||";

                vioSomething = true;

            } else {

                something =
                        "        .-''''-.\n" +
                                eyeLine + "\n" +
                                "     /            \\\n" +
                                "    |    __      |\n" +
                                "    |   / __ \\     |\n" +
                                "    |   \\__/     |\n" +
                                "     \\            /\n" +
                                "      '.        .'\n" +
                                "        '-.__.-'\n" +
                                "          |||";
            }

            // INFO
            System.out.println("\n====================================");
            System.out.println("DIA: " + dia);
            System.out.println("Jugador: " + nombre);

            System.out.println("\nSomething te observa...");
            System.out.println(something);

            // 🧠 MEMORIA / REACCIONES SEGÚN RUTA

            if (modoSunny) {

                if (!escuchoVoz && miedo > 50) {
                    System.out.println("\nSomething: No abras la puerta.");
                    escuchoVoz = true;
                } else if (vioSomething) {
                    System.out.println("\nVoz: ...no es real.");
                } else {
                    System.out.println("\nVoz: Estás soñando.");
                }

            } else if (modoMari) {

                if (cordura < 60) {
                    System.out.println("\nVoz: No es tu culpa...");
                } else {
                    System.out.println("\nVoz: Todo va a estar bien.");
                }

                if (energia < 40) {
                    System.out.println("\nVoz: Descansa un poco.");
                }

            } else if (modoBasil) {

                if (miedo > 60) {
                    System.out.println("\nVoz: Algo nos sigue...");
                } else {
                    System.out.println("\nVoz: No mires atrás...");
                }

                if (vioSomething) {
                    System.out.println("\n...no puedo olvidarlo.");
                }

            } else {

                if (cordura > 60) {
                    System.out.println("\nVoz: Todo está bien...");
                } else {
                    System.out.println("\nSomething: NO MIRES ATRÁS.");
                }
            }

            // ESTADÍSTICAS
            System.out.println("\nCordura: " + cordura + "/100");
            System.out.println("Miedo: " + miedo + "/100");
            System.out.println("Energia: " + energia + "/100");
            System.out.println("Oscuridad: " + oscuridad + "/100");

            // EVENTOS
            int evento = random.nextInt(5);

            switch (evento) {

                case 0 -> System.out.println("\nEscuchas pasos...");
                case 1 -> System.out.println("\nLa habitación se oscurece...");
                case 2 -> System.out.println("\nSientes que algo te observa...");
                case 3 -> System.out.println("\nTu mente se siente pesada...");
                case 4 -> System.out.println("\nSilencio absoluto...");
            }

            // GAME OVER
            if (cordura <= 0 || miedo >= 100 || energia <= 0) {

                System.out.println("\n====================================");
                System.out.println("            GAME OVER");
                System.out.println("====================================");

                if (modoSunny) {
                    System.out.println("\nNo pudiste escapar...");
                } else if (modoMari) {
                    System.out.println("\nLo intentaste demasiado...");
                } else if (modoBasil) {
                    System.out.println("\nTe perdiste en el miedo...");
                } else {
                    System.out.println("\nSomething te alcanzó...");
                }

                break;
            }

            // MENU
            System.out.println("\n1. Luz");
            System.out.println("2. Dormir");
            System.out.println("3. Música");
            System.out.println("4. Mirar");
            System.out.println("5. Salir");

            System.out.print("\nOpcion: ");

            if (!sc.hasNextInt()) {
                sc.next();
                continue;
            }

            int opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {
                    miedo -= 10;
                    oscuridad -= 20;
                    System.out.println("\nEncendiste la luz...");
                }

                case 2 -> {
                    energia += 25;
                    System.out.println("\nIntentas dormir...");
                }

                case 3 -> {
                    cordura += 10;
                    System.out.println("\nLa música te calma...");
                }

                case 4 -> System.out.println("\nNada cambia...");

                case 5 -> {
                    System.out.println("\nTe vas...");
                    return;
                }
            }

            if (cordura > 100) cordura = 100;
            if (miedo < 0) miedo = 0;

            dia++;

            Thread.sleep(2000);
        }

        sc.close();
    }
}