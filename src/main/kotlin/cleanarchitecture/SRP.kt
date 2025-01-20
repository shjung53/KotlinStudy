class Employee {
    fun calculatePay() {
        regularHours()
    }

    fun reportHours() {
        regularHours()
    }

    fun save() {}
}

fun regularHours() {
//    calculateHours
}

// 메서드와 데이터의 분리
class PayCalculator(
    private val data: EmployeeData
) {
    fun calculatePay() {}
}

class HourReporter(
    private val data: EmployeeData

) {
    fun reportHours() {}
}

class EmployeeSaver(
    private val data: EmployeeData
) {
    fun saveEmployee() {}
}

// Facade 패턴을 통해 개별 인스턴스화 및 추적의 어려움 완화
class EmployeeFacade(
    private val payCalculator: PayCalculator,
    private val hourReporter: HourReporter,
    private val employeeSaver: EmployeeSaver,
    private val data: EmployeeData
) {
    fun calculatePay() {
        payCalculator.calculatePay()
    }

    fun reportHours() {
        hourReporter.reportHours()
    }

    fun save() {
        employeeSaver.saveEmployee()
    }
}

data class EmployeeData(
    val id: String
)
