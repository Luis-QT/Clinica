/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.principal.PrincipalController;
import inicio.FramePrincipal;

/**
 *
 * @author Luis
 */
public class PrincipalTest {

    public static void main(String[] args) {
        FramePrincipal fm = new FramePrincipal();
        PrincipalController mec = new PrincipalController(fm);
        mec.index();
    }

}
