
`timescale 1ns/10ps

module tb_ifchain1;

reg clk;
reg rstn;

reg   status;

reg [3:0] a;
reg [3:0] b;

initial begin
    $dumpfile("vcd/ifchain1.vcd");
    $dumpvars(0, tb_ifchain1);
end

initial begin
    $from_myhdl(
        a,
        b,
        clk,
        rstn
    );
    $to_myhdl(
        status
    );
end
//wire rstn;

 

test dut_test(clk, rstn);   

endmodule
