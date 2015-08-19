#!/bin/bash 
#copy xstools test files to home
cp -R xstools_test_files ../                                                                         
#create an installed package list                                               
rpm -qa | sort > ~/pi_pkgs.txt                                                  
                                                                      
#copy files needed by XSTOOLS to python location                                
cp XSBRDINF.xml /usr/lib/python2.7/site-packages                                
cp py_compile.py /usr/lib/python2.7/site-packages                               
                                                                                
#Install pre-compiled version of gtkwave                                        
cd gtkwave-3.3.66                                                               
make install                                                                    
                                                                                
cd ../XSTOOLS                                                                   
python setup.py install                                                         
                                                                                
#Install pre-compiled version of iverilog                                       
cd ../iverilog                                                                  
make install                                                                    
                                                                                
#Installing rpms not installed on image created by Yocto                        
cd  ../wiringpi-extra-rpms/cortexa7hf_vfp_vfpv4_neon/                           
rpm -Uh wiringpi-dbg-git-r0.cortexa7hf_vfp_vfpv4_neon.rpm                       
  
cd ../../gtk-extra-rpms/cortexa7hf_vfp_vfpv4_neon/                    
rpm -Uh gtk-demo-2.24.28-r0.cortexa7hf_vfp_vfpv4_neon.rpm                           
                       
                                                                                
#reboot                                                                         
/sbin/shutdown -r now 
