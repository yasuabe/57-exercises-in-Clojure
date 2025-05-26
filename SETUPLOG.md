# Setup Log
## Spacemacs
1. Back up and remove old Emacs config
```
mv ~/.emacs.d ~/.emacs.d.bak.$(date +%s) 2>/dev/null || true
mv ~/.emacs ~/.emacs.bak.$(date +%s) 2>/dev/null || true
```
*Note: These commands back up existing configurations. If no configuration exists, errors will be ignored.*

2. Clone Spacemacs repo
```
git clone https://github.com/syl20bnr/spacemacs ~/.emacs.d
```

3. Launch Emacs (Spacemacs will self-bootstrap)
```
emacs
```
- Choose vim editing style when prompted.
- Close Emacs after initial setup finishes (`C-x C-c`).

4. Install the Clojure layer
- Edit `~/.spacemacs` (`SPC f e d`).
- Find or add `dotspacemacs-configuration-layers` (inside `dotspacemacs/layers` if not present).
- Add `clojure`.

**Example**
```
   dotspacemacs-configuration-layers
   '(markdown
     emacs-lisp
     helm
     multiple-cursors
     treemacs
     clojure)
```