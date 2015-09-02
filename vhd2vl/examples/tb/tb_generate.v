
`timescale 1ns/10ps
 
module tb_generate1;

reg sysclk;
reg reset;

reg   status;
parameter bus_width=15;
reg [bus_width:0] din;
reg [bus_width:0] rdout;

initial begin
    $dumpfile("vcd/generate1.vcd");
    $dumpvars(0, tb_generate1);
end

initial begin
    $from_myhdl(
	sysclk,
	reset,
	wrb,
	din
	
    );
    $to_myhdl(
        rdout
    );
end
//wire rstn;

 

gen dut_gen(sysclk,
reset,
wrb,
din,
rdout);   

endmodule
