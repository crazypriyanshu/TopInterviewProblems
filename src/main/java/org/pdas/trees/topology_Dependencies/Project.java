package org.pdas.trees.topology_Dependencies;

import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.List;

@Data
public class Project{
    String name;
    List<String> dependencies;
    
}
