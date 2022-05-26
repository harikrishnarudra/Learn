package Interviews.delphix;
/*
===== Summary =====

Given a map of software package dependencies, and a request to install a piece of software, return an ordered list of all pieces of software that must be installed before the requested software can be installed.

Assumptions you can make:

  - Each piece of software will only ever have a single dependency
  - There are no cyclical dependencies and you will always be able
    to return a valid answer.
  - Each software will only appear once as a key in the map of
    software package dependencies

Given is a map of object names, mapped to that object's dependency. For this problem, an object can only have a single dependency, but a single object can be depended on by multiple objects. Any object that has a dependency on None means that it has no dependencies.

No software appears in the left hand column more than once, each object is unique and can only have one dependency.
A software can show up in the right hand column multiple times (a object can be depended on by multiple other objects).

===== Part 1 ======
If a request came in to create object X, we need to return a list in the order that the objects should be created, such that object X was only created once all of its dependencies were also created.

For example, if a request came in to create Gnome 3, we would need to return the following list.

["Boost", "Cairo 2D", "GTK Widget Tookit", "Gnome 3"]

This list says create, in order, Boost, then Cairo 2D, then GTK Widget Toolkit, and finally, Gnome 3.

This is because Gnome 3 depends on GTK Widget, which depends on Cairo 2D, which depends on Boost. Note that Boost does not have any dependencies so it is our final node.

===== Part 2 =====
Handle requests for multiple objects at once. In this example we are asking for objects Gnome 3 and libelf++. Return a single list of which contains dependencies for both objects without duplicates.

[Boost, Cairo 2D, GTK Widget Toolkit, Gnome 3, libelf++] would be a correct solution.
[Boost, Cairo 2D, libelf++, GTK Widget Toolkit, Gnome 3] would also be a correct solution.


import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {

        // software dependency map
        Map<String, String> dependencyMap = new HashMap<>();
        dependencyMap.put("Gnome 3", "GTK Widget Toolkit");
        dependencyMap.put("Boost", null);
        dependencyMap.put("elfutils", "libelf++");
        dependencyMap.put("libelf++", "Cairo 2D");
        dependencyMap.put("GTK Widget Toolkit", "Cairo 2D");
        dependencyMap.put("GDB", "elfutils");
        dependencyMap.put("Cairo 2D", "Boost");
        System.out.println(dependencyMap);

        String software = "Gnome 3";
        List<String> results = getDependencies(dependencyMap, software);
        System.out.println(results);

        List<String> softwares = Arrays.asList("GDB", "Gnome 3");
        Set<String> results = getDependenciesForList(dependencyMap, softwares);
        System.out.println(results);


    }

    public static List<String> getDependencies(Map<String, String> dependencyMap, String key) {
        List<String> resultList = new ArrayList<String>();
        resultList.add(key);
        while (dependencyMap.containsKey(key) && dependencyMap.get(key) != null) {
            key = dependencyMap.get(key);
            resultList.add(key);
        }
        Collections.reverse(resultList);
        return resultList;
    }


    // softwares => m
    // getDeps() => n

    //Else condition => (m-1)*n

    //m*n + (m-1)*n*n => O(n^3)

    public static Set<String> getDependenciesForList(Map<String, String> dependencyMap, List<String> softwares) {
        Set<String> resultList = new LinkedHashSet();
        // List<String> resultList = new ArrayList<String>();
        for (String s : softwares) {
            List<String> res = getDependencies(dependencyMap, s);
            resultList.addAll(res);

      /*
      if(resultList.isEmpty()){
        resultList.addAll(res);
        // resultList = res;
      }else{
        for(String s2:res){
          resultList.addAll(res);
          if(!resultList.contains(s2)){   //O(n)
            resultList.add(s2);
          }

        }

      }
        }
        return resultList;

    }
}*/
public class DependencyTree {
}
