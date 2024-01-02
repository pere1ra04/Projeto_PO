/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author user
 */

public class Ficheiro {
    private File file;

    public Ficheiro (String file) {
        this.file = new File(file);
    }

    public File getFile() {
        return file;
    }

    public Sistema carregarEstado() {
        Sistema sistema = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Estado.txt"))) {
            sistema = (Sistema) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return sistema;
    }

    public void salvarEstado(Sistema sistema) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Estado.txt"))) {
            oos.writeObject(sistema);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
