package com.example.final_mercado_libre.services;

import com.example.final_mercado_libre.entities.Mutante;
import com.example.final_mercado_libre.repositories.MutanteRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class MutanteService implements BaseService <Mutante> {

    //@Autowired    //Genera la inyección de dependencias sin la necesidad de escribir el constructor
    private MutanteRepository mutanteRepository;


    public MutanteService(MutanteRepository mutanteRepository){  //Con esto Spring se encarga de generar inyección de dependencias o lo que equivale a la anotación @Autowired sobre el atributo

        this.mutanteRepository = mutanteRepository;
    }


    @Override
    @Transactional  //El método va a realizar transacciones con la BD. Indica que antes que y después del método va a realizar un transactionBeggin, transc
    public Mutante save(Mutante entity) throws Exception {

        try{
            boolean mutant = isMutant(entity.getDna());

            if(mutant == true) {
                entity = mutanteRepository.save(entity);
                return entity;
            }else{

                throw new Exception();
            }
                //El return no está dentro de la estructura if porque genera un error en el try
        }catch (Exception e){
            throw new Exception(e.getMessage());
       }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try{
            if(mutanteRepository.existsById(id)){
                mutanteRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    public boolean isMutant(String[] dna) {
        boolean mutant = false;
        Character[][] adn;
        adn = new Character[6][6];
        int cont = 0;
        ArrayList<Character> diagP = new ArrayList();
        ArrayList<Character> diagSup = new ArrayList();
        ArrayList<Character> diagSupSup = new ArrayList();
        ArrayList<Character> diagInf = new ArrayList();
        ArrayList<Character> diagInfInf = new ArrayList();
        Character[][] diagInv = new Character[6][6];

        char[] eslabones_cadena_dna_1 = dna[0].toCharArray();
        char[] eslabones_cadena_dna_2 = dna[1].toCharArray();
        char[] eslabones_cadena_dna_3 = dna[2].toCharArray();
        char[] eslabones_cadena_dna_4 = dna[3].toCharArray();
        char[] eslabones_cadena_dna_5 = dna[4].toCharArray();
        char[] eslabones_cadena_dna_6 = dna[5].toCharArray();

        //Control
        char[] controlLetraALetra;

        if (dna.length != 6) {
            //JOptionPane.showMessageDialog(null, "La longitud de alguna cadena es incorrecta.");
            System.out.println("La longitud de alguna cadena es incorrecta.");
            return false;
        } else {

            for (int i = 0; i < dna.length; i++) {
                if (dna[i].length() != 6) {
                    //JOptionPane.showMessageDialog(null, "La cadena " + dna[i] + " tiene longitud incorrecta.");
                    System.out.println("La cadena " + dna[i] + " tiene longitud incorrecta.");
                    return false;
                } else {
                    dna[i] = dna[i].toUpperCase();
                    controlLetraALetra = dna[i].toCharArray();
                    for (int j = 0; j < controlLetraALetra.length; j++) {
                        if (!(controlLetraALetra[j] == 'A' || controlLetraALetra[j] == 'C' || controlLetraALetra[j] == 'G' || controlLetraALetra[j] == 'T')) {
                            //JOptionPane.showMessageDialog(null, "La cadena es erronea debido a una/s letra/s");
                            System.out.println("La cadena es erronea debido a una/s letra/s");
                            return false;
                        }
                    }
                }
            }

            //Cargar matriz y mostrar
            for (int i = 0; i < dna.length; i++) {
                char[] eslabones_cadena_dna = dna[i].toCharArray();

                for (int j = 0; j < dna.length; j++) {
                    adn[i][j] = eslabones_cadena_dna[j];
                }
            }

            for (int i = 0; i < dna.length; i++) {

                System.out.println("[" + " " + adn[i][0] + " " + adn[i][1] + " " + adn[i][2] + " " + adn[i][3] + " " + adn[i][4] + " " + adn[i][5] + " ] ");
            }

            //Analizar
            for (int i = 0; i < adn.length; i++) {

                //Horizontal
                if ((adn[i][0].equals(adn[i][1]) && adn[i][1].equals(adn[i][2]) && adn[i][2].equals(adn[i][3])) || (adn[i][1].equals(adn[i][2]) && adn[i][2].equals(adn[i][3]) && adn[i][3].equals(adn[i][4])) || (adn[i][2].equals(adn[i][3]) && adn[i][3].equals(adn[i][4]) && adn[i][4].equals(adn[i][5]))) {
                    mutant = true;
                }

                //Vertical
                if ((adn[0][i].equals(adn[1][i]) && adn[1][i].equals(adn[2][i]) && adn[2][i].equals(adn[3][i])) || (adn[1][i].equals(adn[2][i]) && adn[2][i].equals(adn[3][i]) && adn[3][i].equals(adn[4][i])) || (adn[2][i].equals(adn[3][i]) && adn[3][i].equals(adn[4][i]) && adn[4][i].equals(adn[5][i]))) {
                    mutant = true;
                }

            }

            //Diagonales
            for (int i = 0; i < adn.length; i++) {
                for (int j = 0; j < adn.length; j++) {
                    //Diagonal Principal(i = j)
                    if (i == j) {
                        diagP.add(adn[i][j]);
                    }

                    //Diagonales superiores (j = i+1 , j = i+2)
                    if (j == i + 1) {
                        diagSup.add(adn[i][j]);
                    }

                    if (j == i + 2) {
                        diagSupSup.add(adn[i][j]);
                    }

                    //Diagonales inferiores (i = j+1, i = j+2)
                    if (i == j + 1) {
                        diagInf.add(adn[i][j]);
                    }

                    if (i == j + 2) {
                        diagInfInf.add(adn[i][j]);
                    }
                }
            }

            //Verificación diagonal principal
            if ((diagP.get(0).equals(diagP.get(1)) && diagP.get(1).equals(diagP.get(2)) && diagP.get(2).equals(diagP.get(3))) || (diagP.get(1).equals(diagP.get(2)) && diagP.get(2).equals(diagP.get(3)) && diagP.get(3).equals(diagP.get(4))) || (diagP.get(2).equals(diagP.get(3)) && diagP.get(3).equals(diagP.get(4)) && diagP.get(4).equals(diagP.get(5)))) {
                mutant = true;
            }
            //Verificación diagonales superiores

            if ((diagSup.get(0).equals(diagSup.get(1)) && diagSup.get(1).equals(diagSup.get(2)) && diagSup.get(2).equals(diagSup.get(3))) || (diagSup.get(1).equals(diagSup.get(2)) && diagSup.get(2).equals(diagSup.get(3)) && diagSup.get(3).equals(diagSup.get(4)))) {
                mutant = true;
            }

            if (diagSupSup.get(0).equals(diagSupSup.get(1)) && diagSupSup.get(1).equals(diagSupSup.get(2)) && diagSupSup.get(2).equals(diagSupSup.get(3))) {
                mutant = true;
            }
            //Diagonales inferiores

            if ((diagInf.get(0).equals(diagInf.get(1)) && diagInf.get(1).equals(diagInf.get(2)) && diagInf.get(2).equals(diagInf.get(3))) || (diagInf.get(1).equals(diagInf.get(2)) && diagInf.get(2).equals(diagInf.get(3)) && diagInf.get(3).equals(diagInf.get(4)))) {
                mutant = true;
            }

            if (diagInfInf.get(0).equals(diagInfInf.get(1)) && diagInfInf.get(1).equals(diagInfInf.get(2)) && diagInfInf.get(2).equals(diagInfInf.get(3))) {
                mutant = true;
            }

            //Generar Matriz invertida por filas
            for (int i = 0;
                 i < diagInv.length;
                 i++) {
                int aux = adn.length - 1;
                for (int j = 0; j < diagInv.length; j++) {
                    diagInv[i][j] = adn[i][aux];
                    aux = aux - 1;
                }
            }

            //Contra diagonales
            for (int i = 0; i < diagInv.length; i++) {
                for (int j = 0; j < diagInv.length; j++) {
                    //Diagonal Principal y diagonales secundarias (j = i+1, j = i+2, i = j+1, i = j+2)
                    if (i == j) {

                        diagP.add(diagInv[i][j]);

                    }
                    //Diagonales superiores
                    if (j == i + 1) {
                        diagSup.add(diagInv[i][j]);
                    }

                    if (j == i + 2) {
                        diagSupSup.add(diagInv[i][j]);
                    }
                    //Diagonales inferiores
                    if (i == j + 1) {
                        diagInf.add(diagInv[i][j]);
                    }
                    if (i == j + 2) {
                        diagInfInf.add(diagInv[i][j]);
                    }

                }
            }
            //Verificación diagonal principal

            if ((diagP.get(0).equals(diagP.get(1)) && diagP.get(1).equals(diagP.get(2)) && diagP.get(2).equals(diagP.get(3))) || (diagP.get(1).equals(diagP.get(2)) && diagP.get(2).equals(diagP.get(3)) && diagP.get(3).equals(diagP.get(4))) || (diagP.get(2).equals(diagP.get(3)) && diagP.get(3).equals(diagP.get(4)) && diagP.get(4).equals(diagP.get(5)))) {
                mutant = true;
            }
            //Verificación diagonales superiores

            if ((diagSup.get(0).equals(diagSup.get(1)) && diagSup.get(1).equals(diagSup.get(2)) && diagSup.get(2).equals(diagSup.get(3))) || (diagSup.get(1).equals(diagSup.get(2)) && diagSup.get(2).equals(diagSup.get(3)) && diagSup.get(3).equals(diagSup.get(4)))) {
                mutant = true;
            }

            if (diagSupSup.get(0).equals(diagSupSup.get(1)) && diagSupSup.get(1).equals(diagSupSup.get(2)) && diagSupSup.get(2).equals(diagSupSup.get(3))) {
                mutant = true;
            }
            //Diagonales inferiores

            if ((diagInf.get(0).equals(diagInf.get(1)) && diagInf.get(1).equals(diagInf.get(2)) && diagInf.get(2).equals(diagInf.get(3))) || (diagInf.get(1).equals(diagInf.get(2)) && diagInf.get(2).equals(diagInf.get(3)) && diagInf.get(3).equals(diagInf.get(4)))) {
                mutant = true;
            }

            if (diagInfInf.get(0).equals(diagInfInf.get(1)) && diagInfInf.get(1).equals(diagInfInf.get(2)) && diagInfInf.get(2).equals(diagInfInf.get(3))) {
                mutant = true;
            }

            if (mutant == true) {
                //JOptionPane.showMessageDialog(null, "¡El humano es mutante!");
                System.out.println("¡El humano es mutante!");
            } else {
                //JOptionPane.showMessageDialog(null, "El humano NO es mutante.");
                System.out.println("El humano NO es mutante.");
            }
        }

        return mutant;
    }


}
