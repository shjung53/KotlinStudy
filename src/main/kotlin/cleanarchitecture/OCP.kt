/*
// SRP 위반으로 인해 OCP도 위반
class Human {
    // drive()가 drive 행위 외에 car 생성 책임도 지고 있음
    // complexArgs가 변경되면 Human의 drive()도 변경됨, 변경에 열려있게 되어버림
    fun drive() {
        val args = ""
        val car = Car(args)
        car.drive()
    }
}

class Car(private val complexArgs: String) {
    fun drive() {
//    drive a car
    }
}
*/

/*class Human {
    //    이제는 Car의 상세구현이 변경되어도 Human에서 변경할 것이 없다. 변경에 닫힘
//    하지만 확장에는 닫혀있음, Car 대신 다른 탈것을 타고 싶으면 변경이 필요함
    fun drive(car: Car) {
        car.drive()
    }
}

class Car(private val complexArgs: String) {
    fun drive() {
//    drive a car
    }
}*/

class Human {
//    vehicle interface에 대한 의존을 통해 확장에도 열려있게 됨
    fun drive(vehicle: Vehicle) {
        vehicle.drive()
    }
}

class Car(private val complexArgs: String): Vehicle {
    override fun drive() {
//        drive a car
    }
}

class Truck(private val args: String): Vehicle {
    override fun drive() {
//        drive a truck
    }

}

interface Vehicle {
    fun drive()
}
