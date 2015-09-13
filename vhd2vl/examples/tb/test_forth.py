"""The example was found on the internet
Now a test bench is being created to test
using myhdl, iverilog & vvp 
"""
from __future__ import division
from __future__ import print_function
from myhdl import *
import os
import argparse
from argparse import Namespace
def test_bench(args):
    """Need to create the signals that are to be tested
    module j1(
    input sys_clk_i, input sys_rst_i, input [15:0] io_din,
    output io_rd, output io_wr, output [15:0] io_addr, output [15:0] io_dout);
    """
    
    sys_clk_i = Signal(bool(0))
    sys_rst_i = Signal(bool(0))
    io_din = Signal(intbv(0)[16:])
    
    
    io_rd = Signal(bool(0))
    io_wr = Signal(bool(0))    
    io_addr = Signal(intbv(0)[16:])
    io_dout = Signal(intbv(0)[16:])

 
    """Need to define stimlus"""
    @instance
    def stimlus():
		sys_rst_i.next = 1
		yield clk.posedge
		sys_rst_i.next = 0
		yield sys_clk_i.posedge		
		for i in range(10):
			io_din.next = 12
			io_addr.next = 2
			yield sys_clk_i.posedge
		raise StopSimulation
    """Need to create a clkgen that will be returned to simulation
    """
    @always(delay(4))
    def clkgen():
		sys_clk_i.next = not sys_clk_i
    """Need an instance of the test code"""
    tb_dut = _prep_cosim(args, sys_clk_i=sys_clk_i, sys_rst_i=sys_rst_i, io_din=io_din, io_addr=io_addr, io_rd=io_rd, io_wr=io_wr, io_dout=io_dout)
    print("back from prep cosim")
    print("start (co)simulation ...")
    Simulation((tb_dut, clkgen, stimlus)).run()
    
def _prep_cosim(args, **sigs):
    """ prepare the cosimulation environment
    """
    print ("  *%s" %  (sigs))   
    print("compiling ...")
    cmd = "iverilog -o forth ../forth.v ./tb_forth.v"
    print("  %s" %  (cmd))
    os.system(cmd)
    # get the handle to the
    print("cosimulation setup ...")
    cmd = "vvp -m ./myhdl.vpi forth"
    print("  %s" %  (cmd))
    cosim = Cosimulation(cmd, **sigs)
    print("  %s" %  (cosim))
    return cosim
 
if __name__ == '__main__':
	print("Running test...")
	test_bench(Namespace())
