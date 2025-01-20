package cleanarchitecture

class OPS {
    fun op1() {}
    fun op2() {}
    fun op3() {}
}

interface U1Ops {
    fun op()
}

interface U2Ops {
    fun op()
}

interface U3Ops {
    fun op()
}

class U1OpsImplementation(private val ops: OPS) : U1Ops {
    override fun op() {
        ops.op1()
    }
}

class User1 {
    fun op(u1Ops: U1Ops) {
        u1Ops.op()
    }
}
