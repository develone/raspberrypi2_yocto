
`timescale 1ns/10ps

module tb_forth1;

reg sys_clk_i;
reg sys_rst_i;
reg io_rd;
reg io_wr;


reg [15:0] io_din;
reg [15:0] io_addr;
reg [15:0] io_dout
initial begin
    $dumpfile("vcd/forth1.vcd");
    $dumpvars(0, tb_forth1);
end

initial begin
    $from_myhdl(
        io_din,
        io_addr,
        sys_clk_i,
        sys_rst_i
    );
    $to_myhdl(
        io_dout,
        io_rd,
        io_wr
    );
end
//wire sys_rst_i;

 

test dut_test(sys_clk_i, sys_rst_i, io_din, io_addr, io_dout, io_rd, io_wr);   

endmodule
