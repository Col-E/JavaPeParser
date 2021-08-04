package com.company;

import java.io.IOException;

public class ImageSectionHeader {
    public static final int IMAGE_SIZEOF_SHORT_NAME = 8;

    String name;
    long physicalAddr_vSize; // union
    public long virtualAddress;
    public long sizeOfRawData;
    public long pointerToRawData;
    public long pointerToRelocations;
    public long pointerToLinenumbers;
    public int numberOfRelocations;
    public int numberOfLinenumbers;
    public long characteristics;

    static ImageSectionHeader read(LittleEndianReader r)
    {
        ImageSectionHeader hdr = new ImageSectionHeader();

        try {
            hdr.name = r.readString(IMAGE_SIZEOF_SHORT_NAME);
            hdr.physicalAddr_vSize = r.readDword();
            hdr.virtualAddress = r.readDword();
            hdr.sizeOfRawData = r.readDword();
            hdr.pointerToRawData = r.readDword();
            hdr.pointerToRelocations = r.readDword();
            hdr.pointerToLinenumbers = r.readDword();
            hdr.numberOfRelocations = r.readWord();
            hdr.numberOfLinenumbers = r.readWord();
            hdr.characteristics = r.readDword();
        }
        catch (IOException e) { return null; }

        return hdr;
    }

    String getName() { return name; }
    void setName(String Name) {
        name = Name.substring(0, IMAGE_SIZEOF_SHORT_NAME);
    }

    public long getPhysicalAddress() { return physicalAddr_vSize; }
    public void setPhysicalAddress(int addr) { physicalAddr_vSize = addr; }

    public long getVirtualSize() { return physicalAddr_vSize; }
    public void setVirtualSize(int size) { physicalAddr_vSize = size; }
}
