"""The example was generater using vhd2vl
Now a test bench is being generater to test
using myhdo & iverilog 
"""
from __future__ import division
from __future__ import print_function
from myhdl import *
import os
import argparse
from argparse import Namespace
def test_bench(args):
    """Need to create the signals that are to be test
    """
    clk = Signal(bool(0))
    rstn = Signal(bool(0))
    a = Signal(intbv(0)[4:])
    b = Signal(intbv(0)[4:])
    #status = Signal(intbv(0)[1:])
    status = Signal(bool(0))
    print(" %s" % bin(status,1))
    """Need to define stimlus"""
    @instance
    def stimlus():
		rstn.next = 1
		yield clk.posedge
		rstn.next = 0
		yield clk.posedge		
		for i in range(10):
			a.next = 12
			b.next = 2
			yield clk.posedge
		raise StopSimulation
    """Need to create a clkgen that will be returned to simulation
    """
    @always(delay(4))
    def clkgen():
		clk.next = not clk
    """Need an instance of the test code"""
    #dut = _prep_cosim(args, clk=clk, rstn=rstn, a=a, b=b, status=status)
    tb_dut = _prep_cosim(args, clk=clk, rstn=rstn, a=a, b=b, status=status)
    print("back from prep cosim")
    print("start (co)simulation ...")
    Simulation((tb_dut, clkgen, stimlus)).run()
    
def _prep_cosim(args, **sigs):
    """ prepare the cosimulation environment
    """
    print ("  *%s" %  (sigs))   
    print("compiling ...")
    cmd = "iverilog -o ifchain ../ifchain.v ./tb_ifchain.v"
    print("  %s" %  (cmd))
    os.system(cmd)
    # get the handle to the
    print("cosimulation setup ...")
    cmd = "vvp -m ./myhdl.vpi ifchain"
    print("  %s" %  (cmd))
    cosim = Cosimulation(cmd, **sigs)
    print("  %s" %  (cosim))
    return cosim
 
if __name__ == '__main__':
	print("Running test...")
	test_bench(Namespace())
