package main

import (
"fmt"
)

/*Jacob Maurer, February 28th 2020, a Go language program that loads 
creates a virtual map of adjacent cities and finds the shortest path
from any city on the map to Bucharest (the image of the map can be found
in the dropbox)*/

//to represent cities on the map
type city struct {

    cityName string
    //straight line distance from Bucharest (destination); used as a heuristic in the problem
    sldBucharest int
    adjacentCities [10]*city
    //distance to adjacent city is recorded in the same index of the array below
    distanceCities [10]int
}

//the shortest path algorithm
func shortestPath(start *city, end city) {

  //print the path
  println(start.cityName)
  //if the destination has been found
  if(start.cityName == end.cityName) {
    return
  }

  if(start.cityName != end.cityName) {
    //int for the loop
    var i int = 0
    //cost of the best choice
    var bestChoiceCost int = 9999
    //index of best choice
    var bestChoice int = 0
    
    //loop through all adjacent cities and compare the find the lowest path cost + sld
    for start.distanceCities[i] != 0 {
      if(start.adjacentCities[i].sldBucharest + start.distanceCities[i] < bestChoiceCost) {
        bestChoiceCost = start.adjacentCities[i].sldBucharest + start.distanceCities[i]
        bestChoice = i
      }
      i++
    }
    
    //do the same for the city chosen as the best city to travel to next
    shortestPath(start.adjacentCities[bestChoice], end)
  }

}

func main() {

//initialize all the cities
var Arad city
Arad.cityName = "Arad"
Arad.sldBucharest = 366

var Bucharest city
Bucharest.cityName = "Bucharest"
Bucharest.sldBucharest = 0

var Craiova city
Craiova.cityName = "Craiova"
Craiova.sldBucharest = 160

var Dobreta city
Dobreta.cityName = "Dobreta"
Dobreta.sldBucharest = 242

var Eforie city
Eforie.cityName = "Eforie"
Eforie.sldBucharest = 161

var Fagaras city
Fagaras.cityName = "Fagaras"
Fagaras.sldBucharest = 178

var Giurgiu city
Giurgiu.cityName = "Giurgiu"
Giurgiu.sldBucharest = 77

var Hirsova city
Hirsova.cityName = "Hirsova"
Hirsova.sldBucharest = 151

var Iasi city
Iasi.cityName = "Iasi"
Iasi.sldBucharest = 226

var Lugoj city
Lugoj.cityName = "Lugoj"
Lugoj.sldBucharest = 244

var Mehadia city
Mehadia.cityName = "Mehadia"
Mehadia.sldBucharest = 241

var Neamt city
Neamt.cityName = "Neamt"
Neamt.sldBucharest = 234

var Oradea city
Oradea.cityName = "Oradea"
Oradea.sldBucharest = 380

var Pitesti city
Pitesti.cityName = "Pitesti"
Pitesti.sldBucharest = 98

var Rimnicu_Vilcea city
Rimnicu_Vilcea.cityName = "Rimnicu Vilcea"
Rimnicu_Vilcea.sldBucharest = 193

var Sibiu city
Sibiu.cityName = "Sibiu"
Sibiu.sldBucharest = 253

var Timisoara city
Timisoara.cityName = "Timisoara"
Timisoara.sldBucharest = 329

var Urziceni city
Urziceni.cityName = "Urziceni"
Urziceni.sldBucharest = 80

var Vaslui city
Vaslui.cityName = "Vaslui"
Vaslui.sldBucharest = 199

var Zerind city
Zerind.cityName = "Zerind"
Zerind.sldBucharest = 374


//initialize all cities adjacent to each city
Arad.adjacentCities[0] = &Zerind
Arad.adjacentCities[1] = &Sibiu
Arad.adjacentCities[2] = &Timisoara

Arad.distanceCities[0] = 75
Arad.distanceCities[1] = 140
Arad.distanceCities[2] = 118

Bucharest.adjacentCities[0] = &Fagaras
Bucharest.adjacentCities[1] = &Pitesti
Bucharest.adjacentCities[2] = &Giurgiu
Bucharest.adjacentCities[3] = &Urziceni

Bucharest.distanceCities[0] = 211
Bucharest.distanceCities[1] = 101
Bucharest.distanceCities[2] = 90
Bucharest.distanceCities[3] = 85

Craiova.adjacentCities[0] = &Dobreta
Craiova.adjacentCities[1] = &Rimnicu_Vilcea
Craiova.adjacentCities[2] = &Pitesti

Craiova.distanceCities[0] = 120
Craiova.distanceCities[1] = 146
Craiova.distanceCities[2] = 138

Dobreta.adjacentCities[0] = &Mehadia
Dobreta.adjacentCities[1] = &Craiova

Dobreta.distanceCities[0] = 75
Dobreta.distanceCities[1] = 120

Eforie.adjacentCities[0] = &Hirsova

Eforie.distanceCities[0] = 86

Fagaras.adjacentCities[0] = &Sibiu
Fagaras.adjacentCities[1] = &Bucharest

Fagaras.distanceCities[0] = 99
Fagaras.distanceCities[1] = 211

Giurgiu.adjacentCities[0] = &Bucharest

Giurgiu.distanceCities[0] = 90

Hirsova.adjacentCities[0] = &Urziceni
Hirsova.adjacentCities[1] = &Eforie

Hirsova.distanceCities[0] = 98
Hirsova.distanceCities[1] = 86

Iasi.adjacentCities[0] = &Neamt
Iasi.adjacentCities[1] = &Vaslui

Iasi.distanceCities[0] = 87
Iasi.distanceCities[1] = 92

Lugoj.adjacentCities[0] = &Timisoara
Lugoj.adjacentCities[1] = &Mehadia

Lugoj.distanceCities[0] = 111
Lugoj.distanceCities[1] = 70

Mehadia.adjacentCities[0] = &Lugoj
Mehadia.adjacentCities[1] = &Dobreta

Mehadia.distanceCities[0] = 70
Mehadia.distanceCities[1] = 75

Neamt.adjacentCities[0] = &Iasi

Neamt.distanceCities[0] = 87

Oradea.adjacentCities[0] = &Zerind
Oradea.adjacentCities[1] = &Sibiu

Oradea.distanceCities[0] = 71
Oradea.distanceCities[1] = 151

Pitesti.adjacentCities[0] = &Rimnicu_Vilcea
Pitesti.adjacentCities[1] = &Bucharest

Pitesti.distanceCities[0] = 97
Pitesti.distanceCities[1] = 101

Rimnicu_Vilcea.adjacentCities[0] = &Sibiu
Rimnicu_Vilcea.adjacentCities[1] = &Pitesti

Rimnicu_Vilcea.distanceCities[0] = 80
Rimnicu_Vilcea.distanceCities[1] = 97

Sibiu.adjacentCities[0] = &Oradea
Sibiu.adjacentCities[1] = &Arad
Sibiu.adjacentCities[2] = &Rimnicu_Vilcea
Sibiu.adjacentCities[3] = &Fagaras

Sibiu.distanceCities[0] = 151
Sibiu.distanceCities[1] = 140
Sibiu.distanceCities[2] = 80
Sibiu.distanceCities[3] = 99

Timisoara.adjacentCities[0] = &Arad
Timisoara.adjacentCities[1] = &Lugoj

Timisoara.distanceCities[0] = 118
Timisoara.distanceCities[1] = 111

Urziceni.adjacentCities[0] = &Bucharest
Urziceni.adjacentCities[1] = &Vaslui
Urziceni.adjacentCities[2] = &Hirsova

Urziceni.distanceCities[0] = 85
Urziceni.distanceCities[1] = 142
Urziceni.distanceCities[2] = 98

Vaslui.adjacentCities[0] = &Iasi
Vaslui.adjacentCities[1] = &Urziceni

Vaslui.distanceCities[0] = 92
Vaslui.distanceCities[1] = 142

Zerind.adjacentCities[0] = &Oradea
Zerind.adjacentCities[1] = &Arad

Zerind.distanceCities[0] = 71
Zerind.distanceCities[1] = 75


//call the shortestpath function to bucharest
fmt.Println("Shortest Path from Arad to Bucharest:")
shortestPath(&Arad, Bucharest)

}
