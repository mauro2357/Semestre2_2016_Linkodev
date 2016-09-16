/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMAINENTITIES;

/**
 *
 * @author Mateo Ortiz Cano
 */
public class CreadorFincas extends CreadorInmuebles{
    @Override
    public Finca factoryMethod(){
        return new Finca();
    } 
}
