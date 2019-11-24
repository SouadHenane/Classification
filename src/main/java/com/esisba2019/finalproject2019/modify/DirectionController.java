package com.esisba2019.finalproject2019.modify;

import com.esisba2019.finalproject2019.model.Direction;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class DirectionController {
    @GetMapping("/ajouterDirection")
    public String sendForm(Direction direction) {

        return "ajouterDirection";
    }

    @PostMapping("/ajouterDirection")
    public  void addd(Direction direction) throws IOException {
        String uriBase = "http://www.semanticweb.org/amgsoft/ontologies/2019/4/untitled-ontology-3";
        String NS = uriBase + "#";
        OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        base.createOntology(uriBase);
        base.read(new FileManager().get().open("E:\\finalproject2019\\finalproject2019\\finalproject2019\\finalproject2019\\GSH.owl"),null);
        //Creating Classes
        String directionName = direction.getName();
        String motcle = direction.getMotCle();
        OntClass Direction = base.createClass(NS+directionName);
        OntClass Motcle = base.createClass(NS+motcle);
        Direction.addSubClass(Motcle);
        String fileName = "GSH.owl";
        try {
            FileWriter out = new FileWriter( fileName );
            base.write(out, "RDF/XML-ABBREV");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Ontology Created");

    }
}
