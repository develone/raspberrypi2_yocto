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
    bus_width=15
    sysclk = Signal(bool(0))
    reset = Signal(bool(0))
    din = Signal(intbv(0)[bus_width:])
    rdout = Signal(intbv(0)[bus_width:])
    #wrb = Signal(intbv(0)[1:])
    wrb = Signal(bool(0))
    print(" %s" % bin(wrb,1))
    """Need to define stimlus"""
    @instance
    def stimlus():
		reset.next = 1
		yield sysclk.posedge
		reset.next = 0
		yield sysclk.posedge		
		for i in range(10):
			din.next = 12
			rdout.next = 2
			yield sysclk.posedge
		raise StopSimulation
    """Need to create a clkgen that will be returned to simulation
    """
    @always(delay(4))
    def clkgen():
		sysclk.next = not sysclk
    """Need an instance of the test code"""
    #dut = _prep_cosim(args, sysclk=sysclk, reset=reset, din=din, rdout=rdout, wrb=wrb)
    tb_dut = _prep_cosim(args, sysclk=sysclk, reset=reset, din=din, rdout=rdout, wrb=wrb)
    print("back from prep cosim")
    print("start (co)simulation ...")
    Simulation((tb_dut, clkgen, stimlus)).run()
    
def _prep_cosim(args, **sigs):
    """ prepare the cosimulation environment
    """
    print ("  *%s" %  (sigs))   
    print("compiling ...")
    cmd = "iverilog -o generate ../generate.v ./tb_generate.v"
    print("  %s" %  (cmd))
    os.system(cmd)
    # get the handle to the
    print("cosimulation setup ...")
    cmd = "vvp -m ./myhdl.vpi generate"
    print("  %s" %  (cmd))
    cosim = Cosimulation(cmd, **sigs)
    print("  %s" %  (cosim))
    return cosim
 
if __name__ == '__main__':
	print("Running test...")
	test_bench(Namespace())
