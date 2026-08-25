# Microchip comparison gallery

This generated gallery places all sixteen neutral microchip colors in a 4 by 4
grid plus one `minecraft:stone` stock control. Keep the stable commands:

```bash
python gallery/generate.py
python gallery/generate.py --check
python gallery/lint.py
bash gallery/package.sh /tmp/little_big_redstone-gallery.zip
```

Keep gallery generation deterministic, bounded, synthetic where practical, and
free of candidate assets or captured meshes.
